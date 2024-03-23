/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelss;

//import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author javier
 */
public class encriptAES {
    String llave;

    public encriptAES(String llave) {
        this.llave = llave;
    }
    
    private SecretKeySpec CrearClave(String llav){
        try{
            byte cadena[] = llav.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec skSpec = new SecretKeySpec(cadena,"AES");
            return skSpec;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public String Encriptar(String encriptar){
        try{
            encriptar = encriptar.replace("ñ", "/A3420");
            encriptar = encriptar.replace("Ñ", "/A3421");
            SecretKeySpec skSpec = CrearClave(this.llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skSpec);
            byte cadena[] = encriptar.getBytes("UTF-8");
            byte encriptada[] = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.encode(encriptada);
            //String cadena_encriptada = 
            return cadena_encriptada;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
    public String Desencriptar(String desencriptar){
        try{
            SecretKeySpec skSpec = CrearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skSpec);
            byte cadena[] = Base64.decode(desencriptar);
            byte[] desencriptacion = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacion);
            cadena_desencriptada = cadena_desencriptada.replace("/A3420", "ñ");
            cadena_desencriptada = cadena_desencriptada.replace("/A3421", "Ñ");
            return cadena_desencriptada;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
