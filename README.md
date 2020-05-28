# android_practice

2020/03/31 HelloAndroid MyApplication SimpleCalculator

2020/04/01 FavoritePet FavoriteAndroid

2020/04/04 MyApplication2 MyApplication3 MyApplication4

2020/04/06 layout_practice

2020/04/09 (~ layout_practice) TableCalculator

2020/04/10 (~ layout_practice) Chapter5_7 GridCalculator

2020/04/14 AdvancedWidgets TimeReservation ScrollList

2020/04/15 (~AdvancedWidgets) AutoFlipping TabHostPet

2020/04/23 MenuChangingBackground ButtonMenu AlertDialog

2020/04/29 SimpleDiary SDImageViewer 

2020/05/28 FireBaseDBTest

-----------------------

## ListView 간단 사용법

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
----------------------

## SharedPreference 간단 사용법

```
        SharedPreferences sharedPreferences = getSharedPreferences("file", MODE_PRIVATE);
        //"file"은 파일 이름, 모드 설정
        String value = sharedPreferences.getString("text","");
        //위 sharedPreference에 "text"로 저장된 값을 value로 받아옴, 존재하지 않는 경우 ""
        editText.setText(value);
```

```
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //앱 종료시 저장하기 위함
        String value = editText.getText().toString();
        
        SharedPreferences sharedPreferences = getSharedPreferences("file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        editor.putString("text", value);
        editor.commit();
        //"text"로 value를 저장, commit
    }
```
----------------------

### layout_weight로 꽉 채우기
> TimeReservation 레이아웃 -> 꽉 채우고 싶은 레이아웃에 layout_weight = 1 지정. 
