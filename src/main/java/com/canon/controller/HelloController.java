package com.canon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.canon.base.common.ServiceContext;
import com.canon.base.common.UserContext;
import com.canon.base.model.RestObject;
import com.canon.base.util.DESUtil;
import com.canon.base.util.RSAUtils;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import static com.canon.base.util.RSAUtils.*;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:21
 * @Description:
 */
@Controller
public class HelloController {

    private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKiLpg8SZprr5ntE5uVjm43daYDDZPeIRjnJ2j8KYlpUnNrIg+5v/PxmaRGMeFH2oUo+u7+Ee5ZpSq7mgeqSmmKK2BZwtafn87F/q663SKEfomSaFID00iyaKrowBd+S7355fvDkiZ9Bwd6pSfJPSXDjM9dsUxyv2a3kOC6EsVzRAgMBAAECgYEAoxScVLEFPplKpbOBhire9GFsF/73ztq4uGmrFpxBlg2Qx9CEd008iCu/Ng+ozAXLAj+5AhJ6UosGjDzVL9cyMNxofnMNx34rFb0A8MWz2Ctu9TMLPoN9REz1gfyjBk1O55Df5slImYI5K5kkY1BqahxnEkqcIueFW9ARkfDjBlECQQDcHa8b+udbb6Wq7QQVGdNeaCsoEhcaGbfssqKqwH+k6mvdxZndK60zMn/kIgQCQ59//rWwSGIdMMoYK2xJTK/3AkEAxAW5ZhaLmT8X1DN6BCsprJfmA8uI+jXyD4fjpLUwtepgO/+mu3jeprs86fEnXa5Mu8bLl6ZcUPeVX/aYVU63dwJADHbF1qDDfwL4b5BSPdujg2IEp5U2p6yzJH0NBvw1fiIkD3/D8akqeo6ufT2L2pD3tCi5Iw1GOP7tQqcaz5+/CwJAAfTEqt4iun7EsBtrZks/+Tby1qrbTRPovHrwrJ4aRFZ4a2DbuxczsZpAu1zqtaadoWoUcgj49t3hobmGP6OvdQJAcAYygGZ+gi2rCkFwDLWmfofzdhafRFRwATz5ap5BV+ypag12a1ZkAXQKPp0wvkG7M8O6ssj6Ow2VPgMIldqlrQ==";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoi6YPEmaa6+Z7ROblY5uN3WmAw2T3iEY5ydo/CmJaVJzayIPub/z8ZmkRjHhR9qFKPru/hHuWaUqu5oHqkppiitgWcLWn5/Oxf6uut0ihH6JkmhSA9NIsmiq6MAXfku9+eX7w5ImfQcHeqUnyT0lw4zPXbFMcr9mt5DguhLFc0QIDAQAB";

    @GetMapping("/hello")
    public Serializable helloWorld() {
        return "hello world";
    }

    @GetMapping("/index")
    public ModelAndView getIndex(ModelAndView modelAndView) {
        UserContext currentUser = ServiceContext.getCurrentUser();
        currentUser = new UserContext();
        currentUser.setUserName("阳光帅气小凡凡");
        modelAndView.addObject("userName", "28 IT man");
        modelAndView.setViewName("index");
        Map<String, Object> model = modelAndView.getModel();
        model.put("nickName", "ni da ye");
        modelAndView.addAllObjects(model);
        return modelAndView;
    }

    @GetMapping("doindex")
    public String doIndex(Model model) {
        UserContext currentUser = ServiceContext.getCurrentUser();
        currentUser = new UserContext();
        currentUser.setUserName("阳光帅气小凡凡");
        model.addAttribute("user", currentUser);
        model.addAttribute("userName", "woca");
        model.addAttribute("nickName", "nima");
        return "index";
    }

    @RequestMapping("http/test")
    @ResponseBody
    public RestObject httptest(@RequestBody String data) throws Exception {

        System.out.println("解密前内容:" + data);
        JSONObject parse = JSONObject.parseObject(data);
        String string = parse.getString("data");
        System.out.println(string);
        // 生成密钥对
        String decryptData = DESUtil.decryptDefault(string);
        System.out.println("解密后内容:" + decryptData);

        return RestObject.getOk("ok");
    }

    @RequestMapping("http/rsa")
    @ResponseBody
    public RestObject httprsa(@RequestBody String data) throws Exception {

        System.out.println("解密前内容:" + data);
        JSONObject parse = JSONObject.parseObject(data);
        String string = parse.getString("data");
        System.out.println(string);
        // 生成密钥对
        String decryptData = decrypt(string, getPrivateKey(privateKey));
        System.out.println("解密后内容:" + decryptData);
        String sign = RSAUtils.sign(decryptData, getPrivateKey(privateKey));
        System.out.println("sign: " + sign);
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("sign", sign);
        return RestObject.getOk(map);
    }

    public static void main(String[] args) throws Exception {
        String str = "XfjyHBlQD8czS3eMjfquEWKKuO+yINXAggT1kRAiOZG5r7cm+qegnRU29i/XbjYg7Jt+zs2Dpi3qlIY6XZEp4X/cz58W6swGucCPA8OtoRZpM4KlMs4G1HuwalyVRBeje6d5ZgMGC9pjgrsX5eFt2RaOIwQyCVqztN/IeaTKx8g=";
//        PrivateKey privateKey = getKeyPair().getPrivate();
//        String decryptData = decrypt(str, privateKey);
//        System.out.println(decryptData);

        KeyPair keyPair = getKeyPair();
//            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
//            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
//            System.out.println("私钥:" + privateKey);
//            System.out.println("公钥:" + publicKey);
        // RSA加密
        String data = "待加密的文字内容111111";
        String encryptData = encrypt(data, getPublicKey(publicKey));
        System.out.println("加密后内容:" + encryptData);
        // RSA解密
        String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
        System.out.println("解密后内容:" + decryptData);
    }
    public static Map<String, String> getMap() {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "张三");
        map.put("nickName", "李四");
        map.put("otherName", "王五");
        return map;
    }

}
