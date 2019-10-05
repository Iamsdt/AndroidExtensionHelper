# Android Extension Helper

Collections of **Extension Function** for **Android**

## Classes

- [Android Views Extension]()
- [Android Activity Extension]()
- [kotlin Coroutine Extension]()
-  [Android Network Extension]()
- [Live Data Extension]()
- [Conveters Extension]()

## How to Config

Add below code in your project level **build.gradle** file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add this line in your app level **build.gradle** file

```css
implementation 'com.github.Iamsdt:AndroidExtensionHelper:v2.1'
```

## Android Views Extension

##### Show View

```kotlin
val tv:TextView = ...
//set view as visible
tv.show()
```

##### Hide View