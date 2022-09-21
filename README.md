REMOVE & POP BACKSTACK FRAGMENT

___

XÂY DỰNG AFragment

- __fragment_a.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ff0">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:text="Fragment A"
        android:textSize="60sp" />

</LinearLayout>
```

- __AFragment.java__
```java
package com.hienqp.fragmentremoveandpopbackstack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class AFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        return view;
    }
}
```


XÂY DỰNG BFragment

- __fragment_b.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#f0f">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:text="Fragment B"
        android:textSize="60sp" />

</LinearLayout>
```

- __BFragment.java__
```java
package com.hienqp.fragmentremoveandpopbackstack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class BFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        return view;
    }
}
```

XÂY DỰNG CFragment

- __fragment_c.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#f00">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:text="Fragment C"
        android:textSize="60sp" />

</LinearLayout>
```

- __CFragment.java__
```java
package com.hienqp.fragmentremoveandpopbackstack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class CFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);

        return view;
    }
}
```

___

LAYOUT CỦA MAIN ACTIVITY

- trong phần này ta sẽ thực hiện remove 1 Fragment được ánh xạ đến Fragment đã tồn tại bởi Tag của Fragment đó
- giao diện MainActivity ta có sẽ như sau:

<img src="https://github.com/hienqp/ngay044-Fragment-FragmentRemoveAndPOPBackStack/blob/main/main_screen.png">

- trong đó, khung viền đỏ sẽ là nơi chứa 1 Fragment bất kỳ được gọi ra
- như vậy ta sẽ thiết kế 
	- 3 Button dùng để add Fragment vào vùng trống có viền màu đỏ
	- 3 Button dùng để remove Fragment được add vào vùng viền đỏ
	- 1 Button dùng để Back về Fragment trước đó
	- 1 Button dùng để Back trực tiếp về Fragment chỉ định (ở đây là AFragment)
- vùng trống có viền màu đỏ chính là nơi đặt 1 FrameLayout dùng để chứa Fragment được add vào Activity
- các Button này chỉ đơn giản làm nhiệm vụ bắt sự kiện click, nên ta không cần khai báo ánh xạ id để gọi Listener, thay vào đó ta thêm vào thuộc tính ``onClick`` cho mỗi Button trong Layout XML
- với mỗi thuộc tính ``onClick`` của mỗi Button chứa giá trị là String, chính là tên của Method được định nghĩa trong MainActivity, và mỗi khi 1 Button được click thì Method tương ứng của Button đó sẽ được gọi

- __activity_main.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" >

    <Button
        android:onClick="AddA"
        android:id="@+id/button_add_a"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="-1dp"
        android:layout_marginTop="2dp"
        android:text="Add A" />

    <Button
        android:onClick="AddB"
        android:id="@+id/button_add_b"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="105dp"
        android:layout_marginTop="1dp"
        android:text="Add B" />

    <Button
        android:onClick="AddC"
        android:id="@+id/button_add_c"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="1dp"
        android:layout_marginEnd="97dp"
        android:text="Add C" />

    <Button
        android:onClick="Back"
        android:id="@+id/button_back"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="2dp"
        android:layout_marginEnd="0dp"
        android:text="Back" />

    <Button
        android:id="@+id/button_remove_a"
        android:layout_width="100dp"
        android:layout_height="55dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="50dp"
        android:onClick="RemoveA"
        android:text="Remove A" />

    <Button
        android:onClick="RemoveB"
        android:id="@+id/button_remove_b"
        android:layout_width="100dp"
        android:layout_height="55dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="105dp"
        android:layout_marginTop="50dp"
        android:text="Remove B" />

    <Button
        android:onClick="RemoveC"
        android:id="@+id/button_remove_c"
        android:layout_width="100dp"
        android:layout_height="55dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="97dp"
        android:text="Remove C" />

    <Button
        android:onClick="PopA"
        android:id="@+id/button_pop_a"
        android:layout_width="88dp"
        android:layout_height="55dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="0dp"
        android:text="POP A" />

    <FrameLayout
        android:layout_below="@id/button_remove_a"
        android:id="@+id/framelayout_contain_fragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</RelativeLayout>
```

___

ADD FRAGMENT BY TAG

- với Layout được trình bày ở trên của MainActivity, thì 3 Button dùng để add Fragment sẽ có 3 Method, tương ứng với thuộc tính ``onClick`` của mỗi Button
- ta sẽ có Method dùng để add Fragment là: AddA, AddB, AddC
- ta sẽ sử dụng Method add Fragment với 3 tham số, với tham số thứ 3 chính là String Tag Name do ta chỉ định của Fragment được thêm vào
- Tag Name này sẽ được sử dụng lại cho Method remove

- __ActivityMain.java__
```java
package com.hienqp.fragmentremoveandpopbackstack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new AFragment(), "fragA");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new BFragment(), "fragB");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new CFragment(), "fragC");
        fragmentTransaction.commit();
    }
}
```

___

REMOVE FRAGMENT BY TAG

- như Layout của MainActivity thiết kế ta sẽ có 3 Button dùng để remove Fragment được thêm vào FrameLayout
- với mỗi Button sẽ có thuộc tính ``onClick`` chứa giá trị String là tên Method dùng để remove Fragment được thêm vào FrameLayout
- 3 Method dùng để remove Fragment ở MainActivity là: RemoveA, RemoveB, RemoveC
- để remove chính xác Fragment chỉ định, thì trong Method dùng để remove ta cần gọi chính xác Fragment đó, lúc này ta sẽ sử dụng Tag Name đã chỉ định ban đầu khi add Fragment vào FrameLayout để ánh xạ chính xác Fragment cần remove
- trong MainActivity ta thêm vào 3 Method trên, trong mỗi Method ta sẽ ánh xạ đến Fragment chỉ định với lệnh ``findFragmentByTag()`` thông qua ``getFragmentManager()``
- 3 Method remove Fragment trong MainActivity
```
    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AFragment aFragment = (AFragment) getFragmentManager().findFragmentByTag("fragA");
        if (aFragment != null) {
            fragmentTransaction.remove(aFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment A chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BFragment bFragment = (BFragment) getFragmentManager().findFragmentByTag("fragB");
        if (bFragment != null) {
            fragmentTransaction.remove(bFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment B chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CFragment cFragment = (CFragment) getFragmentManager().findFragmentByTag("fragC");
        if (cFragment != null) {
            fragmentTransaction.remove(cFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment C chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        } 
    }
```
- trước khi thực hiện remove Fragment ta phải kiểm tra Fragment được ánh xạ có khác ``null`` hay khi, vì nếu như Fragment chưa được thêm vào, thì khi ánh xạ ta chỉ nhận được 1 Fragment trỏ đến giá trị ``null``, mà khi thao tác với 1 giá trị ``null`` ứng dụng của ta sẽ bị crash    

___

BACK 

- bản chất thì Fragment cũng chỉ là 1 phần giao diện nằm trong Activity, khi nhiều Fragment được gọi liên tục, thì khi ta click quay trở về thì cả Activity đang hiển thị sẽ bị đóng xuống, chứ không phải là quay về Fragment trước đó, vì Fragment thuộc Activity
- vì vậy để có thể thực hiện việc quay trở về Fragment trước đó sau khi đã gọi nhiều Fragment liên tục, ta phải đưa Fragment vào Stack giống như Activity được tự động đưa vào Stack
- Stack là 1 vùng lưu trữ dạng ngăn xếp, data được sắp xếp theo kiểu LIFO (vào sau ra trước), ta sẽ thực hiện việc đưa Fragment vào Stack, và sẽ lấy nó ra khi thực hiện Back, việc này giống như ta quay trở về màn hình trước đó
- để thực hiện được việc này ta phải add Fragment vào Stack ngay khi Fragment được add vào FragmentTransaction
- thông qua FragmentTransaction ta gọi Method ``addToBackStack(String)`` với tham số String là tên hay Tag name của Fragment ta đưa vào Stack để Stack quản lý, và khi ta gọi nó ra ta sẽ sử dụng lại tham số String Tag name này
- ở mỗi Method add Fragment ta thêm lệnh ``addToBackStack(String)``

```java
    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new AFragment(), "fragA");
        fragmentTransaction.addToBackStack("aaa");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new BFragment(), "fragB");
        fragmentTransaction.addToBackStack("bbb");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new CFragment(), "fragC");
        fragmentTransaction.addToBackStack("ccc");
        fragmentTransaction.commit();
    }
```  

- sau khi Fragment được add vào Stack với Method ``addToBackStack(String)`` ta có thể sử dụng Button Back của thiết bị để quay trở về những Fragment được thêm vào trước đó
- với phần này ta sẽ cài đặt Method cho Button Back ta đã thêm vào trước đó với công dụng giống như Button Back của thiết bị
- ở Layout thì View của Button Back ta đã thiết lập thuộc tính ``onClick`` là tên Method được gọi khi click vào Button Back trên màn hình ứng dụng
- ta thêm Method Back vào MainActivity để thực hiện quay trở về (lấy trong Stack thành phần được thêm vào liền kề trước đó) khi có sự kiện click vào Button Back

```java
    public void Back(View view) {
        getFragmentManager().popBackStack();
    }
```

- Method Back ở trên cũng không khác Button Back của thiết bị, nếu có là khi không còn Fragment nào trong Stack, màn hình sẽ đứng yên, còn Button Back của thiết bị sẽ đóng ứng dụng khi không còn gì để lấy ra khỏi Stack


POP BACK STACK

- với Method Back như trên, ta chỉ có thể trở về tuần tự lần lượt các Fragment
- nhưng để trở về trực tiếp 1 Fragment nào đó, thì ở ``popBackStack()`` ta thêm vào 2 tham số
    - String: Tag name dùng để xác định Fragment được đưa vào Stack
    - int: mặc định ta truyền vào giá trị 0, vì ta chỉ pop 1 phần tử trong Stack

```java
    public void PopA(View view) {
        getFragmentManager().popBackStack("aaa", 0);
    }
```

- ngoài ra ta cũng có thể cài đặt cho sự kiện cho Button Back của thiết bị bằng cách gọi override Method ``onBackPressed()``

```java
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
``` 

- trên đây là mặc định khi override ta gọi __super__ đến Method ``onBackPressed()`` của Activity
- ta có thể thiết lập lại như sau:
    - khi user click vào Button Back của thiết bị, sẽ quay trở về Fragment trước đó
    - kiểm tra khi không còn Fragment nào trong Stack thì đóng Activity

```java
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
```                   