主功能 index.html
================
可以顯示所有 server 收到的 http request 及其 parameter map。

如果 http request 的對象是：

* /api/image.jsp
* /api/report.jsp

則會特別顯示「影像完成」/「報告完成」，也只會顯示 parameter 下列項目的對應值：

* 00101000：Patient ID
* 00080050：Accession Number


Echo
====
這個 project 也提供 `/api/image.jsp` 與 `api/report.jsp`，
可顯示 echo 訊息。