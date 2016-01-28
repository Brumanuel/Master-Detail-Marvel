package com.garcilomanuel.masterdetailmarvel.data.marvel.requestinterceptor;

import com.garcilomanuel.masterdetailmarvel.data.marvel.ApiParams;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import retrofit.RequestInterceptor;

/**
 * Created by Manuel García.
 */
public class MarvelRequestInterceptor implements RequestInterceptor {

  private String publicKey;
  private String privateKey;

  public MarvelRequestInterceptor(String publicKey, String privateKey) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  //Add timestamp, public key and hash to the header for authentication
  @Override
  public void intercept(RequestFacade request) {
    long timeStamp = System.currentTimeMillis();
    request.addEncodedQueryParam(ApiParams.PARAM_TIMESTAMP, String.valueOf(timeStamp));
    request.addEncodedQueryParam(ApiParams.PARAM_API_KEY, String.valueOf(publicKey));
    request.addEncodedQueryParam(ApiParams.PARAM_HASH, String.valueOf(generateHash(timeStamp)));
  }

  //Generate the value of params hash with the md5 of the sum of timestamp, private key + public key
  private String generateHash(long timestamp) {
    return md5(timestamp + privateKey + publicKey);
  }

  //Md5 hash algorithm, found on the internet.
  private String md5(final String s) {
    final String MD5 = "MD5";
    try {
      // Create MD5 Hash
      MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      // Create Hex String
      StringBuilder hexString = new StringBuilder();
      for (byte aMessageDigest : messageDigest) {
        String h = Integer.toHexString(0xFF & aMessageDigest);
        while (h.length() < 2) {
          h = "0" + h;
        }
        hexString.append(h);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
