<#-- 输出 markdown 模板 -->
<#-- 变量名与FreeMarker 里面的 Model 里面的 HashMap 的 key 对应 -->
${Topic}

<#list BookDataList as bookData>
${bookData.title}
${bookData.mark}
${bookData.fileName}
${bookData.selectedText}

</#list>