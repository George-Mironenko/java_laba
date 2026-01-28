package BCipher;

public class Main {
    public static void demonstrateCipher(String text){
        BCipher cipher = new BCipher();

        System.out.println("Исходный текст: " + text);

        String encrypted = cipher.encode(text);
        System.out.println("Зашифрованный:  " + encrypted);

        String decrypted = cipher.decode(encrypted);
        System.out.println("Расшифрованный: " + decrypted);
        System.out.println();
    }

    public static void  main(String args[]){
        demonstrateCipher("  ");
        demonstrateCipher("Бог Умер! - Ницше");
        demonstrateCipher("Выдвигаемся завтра в шесть");
        demonstrateCipher(BCipher.RUSSIAN_LOWER);
        demonstrateCipher("Microsoft - это it компания");
        demonstrateCipher("休 - «отдыхать» — состоит из иероглифов «человек");

    }

}
