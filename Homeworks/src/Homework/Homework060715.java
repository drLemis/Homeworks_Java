package Homework;

/**
 * ���������:
 * �������� ������ Int (UPD: ��� ���������� - ���� ���� ���������� �����)
 * � ������� �������� �������� ����� ���������� ��� �������� ������� � ������ �� length
 * ������� � ����� ����������� ���������� [0]
 * ������ � �������� �� ������� �������������� �� [n]
 * �������� �������� �� ������� - � ����������� � ��������� �������?
 *
 * P.S.: ���� �� �� �������, ���������� � ������ ����
 */


public class Homework060715 {

    private static int[] massive = new int[999]; //� ��� ��� �����, ��� �� �����
//�� ������ - ��������� ��������� ��� �������, ������ � ���������� � ��������� ����� ����
//������������� ���� ���� "massive[]" ������� ����� ���������? ����� ����, ��� ����������
//�� ��������� ��� ��� ���� �������� ��� ������� � ����� � ���������� - �� ������
//������� �� ���� ����������, ������-�����

    public static void main(String[] args){
        //�������� ����� ��� �����
        System.out.println("������� ���� ���������. ��� �� ��� �����������, �������� ������� ������ ������.");
        addInEnd(123, false, false);
        addInEnd(123, true, false);
        addInEnd(321, false, false);
        addInEnd(213, false, false);
        addInEnd(231, false, false);
        System.out.println("������� ��� � �� ����������");
        for (int i = 1; i <= howMuch(); i++) {
            System.out.println(get(i));
        }
        System.out.println(howMuch());
        System.out.println("---������ ������---");
        del(2);
        for (int i = 1; i <= howMuch(); i++) {
            System.out.println(get(i));
        }
        System.out.println(howMuch());
    }

    //������������� ������� ��� ���������� � ����� � ���������
    public static void addInEnd(int newint, boolean unic, boolean compare){
        if (unic){
//�������� ������������ - ��������� �� �������� ���� ���������
            for (int i = 1; i < massive[0]+1; i++) {
                if (massive[i] == newint){
                    return;
                }
            }
        }
        if (compare){
//������� �������� (���� ��� ���� �� ����� �� int - �� ���������, �� ���� ����, ������ �����)
        }
        int n = massive[0]+1;
        massive[n] = newint;
        massive[0]+=1;
    }

    //�������� �� ������� �� ������� �� ������ �����
    public static void del(int index){
        for (int i = index; i < massive[0]+1; i++) {
            massive[i] = massive[i+1];
        }
        massive[0]-=1;
//������� ��������� �����, �� � ������ � �� ���� ���
    }

    //��������� �� ������� - 0 ����� ���������
    public static int get(int index){
        if (index != 0) {
            return massive[index];
        }
        else {
            return massive[massive[0]];
        }

    }

    //��������� ���������� �������� ��������� - ������, ���������� �������
    public static int howMuch(){
        return massive[0];
    }

//���� �� ������� ��������, � ���� ����� ���������� ����� �� ��� ����� �����

}