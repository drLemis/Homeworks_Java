package Homework;

/**
 * —труктура:
 * ’ранимый массив Int (UPD: как вы€снилось - иде€ была неверо€тно тупой)
 * ¬ нулевом элементе хранитс€ общее количество дл€ быстрого доступа и отказа от length
 * ¬ставка в конец реализуетс€ содержимым [0]
 * ƒоступ к элементу по индексу осуществл€етс€ по [n]
 * ”даление элемента по индексу - с сортировкой и удалением индекса?
 *
 * P.S.: —ами мы не местные, документов и знаний нету
 */


public class Homework060715 {

    private static int[] massive = new int[999]; //и вот тут дошло, что всЄ херн€
//на пам€ть - прочитать нормально про массивы, узнать о расширении и научитьс€ юзать лист
//использование кода вида "massive[]" создаст новый последний? Ќужны маны, нет интернетов
//всЄ убожество что тут есть написано без доступа к манам и интернетам - из головы
//хороший из мен€ говнокодер, бэйсик-стайл

    public static void main(String[] args){
        //засунуто чисто дл€ теста
        System.out.println("ƒобавим п€ть элементов. ƒва из них повтор€ютс€, проверку пройдут только четыре.");
        addInEnd(123, false, false);
        addInEnd(123, true, false);
        addInEnd(321, false, false);
        addInEnd(213, false, false);
        addInEnd(231, false, false);
        System.out.println("¬ыведем все и их количество");
        for (int i = 1; i <= howMuch(); i++) {
            System.out.println(get(i));
        }
        System.out.println(howMuch());
        System.out.println("---”далим второй---");
        del(2);
        for (int i = 1; i <= howMuch(); i++) {
            System.out.println(get(i));
        }
        System.out.println(howMuch());
    }

    //универсальный комбайн дл€ добавлени€ в конец с услови€ми
    public static void addInEnd(int newint, boolean unic, boolean compare){
        if (unic){
//проверка уникальности - сравнение на равность всем остальные
            for (int i = 1; i < massive[0]+1; i++) {
                if (massive[i] == newint){
                    return;
                }
            }
        }
        if (compare){
//услови€ проверки (пока что если на входе не int - всЄ посыпетс€, но суть €сна, допишу потом)
        }
        int n = massive[0]+1;
        massive[n] = newint;
        massive[0]+=1;
    }

    //удаление по индексу со сдвигом на пустое место
    public static void del(int index){
        for (int i = index; i < massive[0]+1; i++) {
            massive[i] = massive[i+1];
        }
        massive[0]-=1;
//удалить последний нужно, но € глупый и не знаю как
    }

    //получение по индексу - 0 вернЄт последний
    public static int get(int index){
        if (index != 0) {
            return massive[index];
        }
        else {
            return massive[massive[0]];
        }

    }

    //получение количества хранимых элементов - привет, некрасивые костыли
    public static int howMuch(){
        return massive[0];
    }

//дико не хватает познаний, с гор€ нужно начитатьс€ манов на всю жизнь вперЄд

}