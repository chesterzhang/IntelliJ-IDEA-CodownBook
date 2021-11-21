<#-- markdown  template -->
<#-- variable name should be the same with keys of HashMap of model of FreeMarker -->
## ${Topic}

[TOC]

<#list BookDataList as bookData>

### ${bookData.title}
*${bookData.note}*

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