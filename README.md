# android_practice

2020/03/31 HelloAndroid MyApplication SimpleCalculator

2020/04/01 FavoritePet FavoriteAndroid

2020/04/04 MyApplication2 MyApplication3 MyApplication4

2020/04/06 layout_practice

2020/04/09 (~ layout_practice) TableCalculator

2020/04/10 (~ layout_practice) Chapter5_7 GridCalculator

-----------------------

## ListView 사용법

```
        list = (ListView)findViewById(R.id.list); 

        List<String> data = new ArrayList<>(); //List는 인터페이스
        //String 형의 리스트 data를 생성
       
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        //String 형의 ArrayAdapter인 adapter 생성하고 data를 연결(파라미터)
        
        list.setAdapter(adapter);
        //리스트뷰에 adapter를 연결
        
        data.add("안드로이드");
        data.add("자바");
        data.add("파이썬");
        data.add("C/C++");
        //리스트 data에 요소 추가
        
        adapter.notifyDataSetChanged();
        //리스트뷰 갱신
```
