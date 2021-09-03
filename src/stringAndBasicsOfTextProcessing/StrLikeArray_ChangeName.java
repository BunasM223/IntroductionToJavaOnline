package stringAndBasicsOfTextProcessing;
/*
Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class StrLikeArray_ChangeName {
    public static void main(String[] agrs) {
        String camelCase [] = new String[10];
        for (int i = 0; i < camelCase.length; i++) {
            camelCase[i] = "camel" + (i+1);
        }
        System.out.println("Исходный массив:");
        for (String elem : camelCase) {
            System. out. printf(elem + " ");
        }
        System.out.println();

        for (int i = 0; i < camelCase.length; i++) {
            camelCase[i] = camelCase[i].replace("camel","snake");
        }
        System.out.println("Массив после замены:");
        for (String elem : camelCase) {
            System. out. printf(elem + " ");
        }
        System.out.println();
    }

}
