// HashSet과 사용자 정의 데이터 타입
package com.eomcs.corelib.ex06;

import java.util.HashSet;

public class Exam03_1 {
    
    // 사용자 정의 데이터 타입 
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + "]";
        }
    }
    
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("유관순", 16);
        
        HashSet set = new HashSet();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5); 
        
        // 출력해보면 "유관순, 16" 데이터가 중복해서 저장되었음을 알 수 있다.
        // 이유?
        // => HashSet이 중복여부를 검사할 때 hashCode()와 equals()의 리턴값으로 판단한다.
        // => Member 클래스에서 hashCode()와 equals()를 오버라이딩 하지 않았기 때문에
        //    Object로부터 상속 받은 hashCode()와 equals()를 그대로 사용하였고, 
        //    Object의 hashCode()는 인스턴스가 다르면 무조건 다른 해시값을 리턴한다.
        //    Object의 equals()는 인스턴스의 주소가 같은 지 검사한다.
        // => 그래서 "유관순,16" 데이터가 같더라도 인스턴스가 다르기 때문에 
        //    같은 값으로 간주하지 않은 것이다.
        
        print(set);
    }
    
    static void print(HashSet set) {
        Object[] values = set.toArray();
        for (Object value : values) {
            System.out.println(value);
        }
    }
}









