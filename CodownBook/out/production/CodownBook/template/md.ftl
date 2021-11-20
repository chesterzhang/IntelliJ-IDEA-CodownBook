<#-- 输出 markdown 模板 -->
<#-- 变量名与FreeMarker 里面的 Model 里面的 HashMap 的 key 对应 -->
## ${Topic}

[TOC]

<#list BookDataList as bookData>

### ${bookData.title}
*${bookData.mark}*

```java
${bookData.fileName}

${bookData.selectedText}
```

```
Function Information:
---------------------
Function name: ${bookData.funcName}
Access modifier: ${bookData.funcAccModifier}
Return value type: ${bookData.funcReturnType}
Parameters: ${bookData.funcParameters}
---------------------
```



</#list>