package com.airlines.security.certificates;

import com.airlines.common.constant.Constant;
import com.airlines.common.constant.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
@Slf4j
public class SecurityCertificatesManager {

    @Value("${security.certificates.keys.public}")
    private String publicKey;

    @Value("${security.certificates.keys.private}")
    private String privateKey;

    public PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        publicKey = publicKey.replace(MessageConstant.PUBLIC_KEY_START_TEXT, Constant.EMPTY)
                .replace(MessageConstant.PUBLIC_KEY_END_TEXT, Constant.EMPTY);
        return KeyFactory
                .getInstance(MessageConstant.RSA)
                .generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
    }

    public PrivateKey getPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        privateKey = privateKey.replace(MessageConstant.PRIVATE_KEY_START_TEXT, Constant.EMPTY)
                .replace(MessageConstant.PRIVATE_KEY_END_TEXT, Constant.EMPTY);

        return KeyFactory
                .getInstance(MessageConstant.RSA)
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
    }
}
