<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <h3>����3���� �����ϴ� Part �������̽��� �̿��� ���Ͼ��ε�</h3>
    <form method="post" action="UploadServlet3" enctype="multipart/form-data">
        ���ϼ���: <input type="file" name="multiPartServlet" multiple="multiple"/>
        ������: <input type="text" name="sender">
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>