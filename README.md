# DrawableView
可以在布局中直接设置shape背景属性，快速编写带样式的组件

# Features

* 支持所有shape标签的属性
* TextView 设置drawable可以设置图片大小
* TextView 的drawable支持添加点击事件
* Animator动态改变背景

## How To Use  

Step 1. Add the JitPack repository to your build file

```
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency
```
dependencies {
	implementation 'com.github.biby0915:DrawableView:1.0.0'
}
```

在布局文件中使用

![xml](https://github.com/biby0915/DrawableView/blob/master/preview/20190611113318.jpg)
