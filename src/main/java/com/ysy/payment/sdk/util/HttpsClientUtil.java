package com.ysy.payment.sdk.util;


import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
/**
 * 
 * 鍟嗘埛鍙弬鑰冩湰绫荤紪鍐欏彂閫佽姹傛柟娉曪紝涔熷彲鐩存帴浣跨敤鏈被
 *
 */

public class HttpsClientUtil {

	public static HttpClient createAuthNonHttpClient() {
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(100000).build();
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        //鎸囧畾淇′换瀵嗛挜瀛樺偍瀵硅薄鍜岃繛鎺ュ鎺ュ瓧宸ュ巶
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, new AnyTrustStrategy()).build();
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //璁剧疆杩炴帴鍙傛暟
        ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName("utf-8")).build();
        //璁剧疆杩炴帴绠＄悊鍣�
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        connManager.setDefaultConnectionConfig(connConfig);
        connManager.setDefaultSocketConfig(socketConfig);
        //鎸囧畾cookie瀛樺偍瀵硅薄
        BasicCookieStore cookieStore = new BasicCookieStore();
        return HttpClientBuilder.create().setDefaultCookieStore(cookieStore).setConnectionManager(connManager).build();
    }

	
    /**
     * 鍙戦�乯son鏍煎紡璇锋眰鍒版寚瀹氬湴鍧�
     * @param url
     * @param json
     * @return
     */
    public static String sendRequest(String url, String json,String contentType) {
        int timeout=5000;                                     //瓒呮椂鏃堕棿
        String strResult = "";
        HttpResponse resp = null;
        HttpEntity entity = null;
        HttpClient httpClient = createAuthNonHttpClient();//new DefaultHttpClient();
        try {
        	 HttpPost httpPost = new HttpPost(url);
             httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
             HttpEntity postEntity = new StringEntity(json, "utf-8");
             httpPost.setEntity(postEntity);
             resp = httpClient.execute(httpPost);
             entity = resp.getEntity();
             strResult = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	HttpClientUtils.closeQuietly(resp);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return strResult;
    }

    /**
     * https 涓嶉獙璇佽瘉涔�
     * @param httpClient
     */
    public static void wrapClient(HttpClient httpClient) {
        try {
            X509TrustManager xtm = new X509TrustManager() {   //鍒涘缓TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            //TLS1.0涓嶴SL3.0鍩烘湰涓婃病鏈夊お澶х殑宸埆锛屽彲绮楃暐鐞嗚В涓篢LS鏄疭SL鐨勭户鎵胯�咃紝浣嗗畠浠娇鐢ㄧ殑鏄浉鍚岀殑SSLContext
            SSLContext ctx = SSLContext.getInstance("TLS");
            //浣跨敤TrustManager鏉ュ垵濮嬪寲璇ヤ笂涓嬫枃锛孴rustManager鍙槸琚玈SL鐨凷ocket鎵�浣跨敤
            ctx.init(null, new TrustManager[]{xtm}, null);
            //鍒涘缓SSLSocketFactory
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
            //閫氳繃SchemeRegistry灏哠SLSocketFactory娉ㄥ唽鍒版垜浠殑HttpClient涓�
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static class AnyTrustStrategy implements TrustStrategy {

        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            return true;
        }

    }
    
    public static void main(String[] args) {
		sendRequest("https://mch.cspaying.com/cloud/cloudplatform/api/trade.html", "{}", "application/json;charset=UTF-8");
	}
    
}
