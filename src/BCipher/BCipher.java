package BCipher;

public class BCipher implements ICipher {

    static final String RUSSIAN_LOWER  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final int ALPHABET_SIZE = 33;


    public static boolean isBlankText(String str) {
        return str == null || str.isBlank();
    }

    private static int getNumber(char letter) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (RUSSIAN_LOWER .charAt(i) == letter){
                return i + 1;
            }
        }
        return -1;
    }

    public String encode(String text){
        try {

            // Проверям, что строка не пустая
            if (isBlankText(text)){
                return null;
            }

            // Все буквы переводим в нижный редистр
            String strText = text.toLowerCase();

            // Словарь для итого зашифрованного слова
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < strText.length(); i++) {

                char currentChar = strText.charAt(i);

                // Получаем номер буквы
                int numberLetter = getNumber(currentChar);

                // Если это буква 'П' оставляем
                if (numberLetter == 17) {
                    result.append('п');
                } else if (numberLetter == -1) {

                    // Для не-русских букв просто оставляем как есть
                    result.append(currentChar);
                } else {
                    // Добавляем новую букву в словарь
                    char encrypted = RUSSIAN_LOWER.charAt(ALPHABET_SIZE - numberLetter);
                    result.append(encrypted);

                }
            }

            return result.toString();
        }
        catch (Exception error){
                System.out.println(error);
            return null;
        }
    }

    public String decode(String text){
        return encode(text);
    }
}
