<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notice_Detail_Page</title>

    <link rel="stylesheet" href="../../resources/css/Notice_Detail_Page.css">
</head>
<body>
    <section>
        <!-- top -->
        <div id="top">공지사항</div>

        <!-- content -->
        <div id="content">
            <!-- left -->
            <div id="l_blank"></div>

            <!-- center -->
            <div id="main">
                <!-- top -->
                <div id="main-t">
                    <div id="main-t1"><hr></div>
                    <div id="main-t2">${noticeTitle}</div>
                    <div id="main-t3"><hr></div>
                </div>

                <!-- center -->
                <div id="main-c">
                    ${noticeDetail} 
                </div>

                <!-- bottom -->
                <div id="main-b">
                    <div id="main-b1">
                        <div id="main-b1-t"><hr></div>
                        <div id="main-b1-c">
                            <div id="pre-tit">
                                <div id="pre-tit-l">이전 글</div>
                                <div id="pre-tit-r">${preTitle}</div>
                            </div>
                            <div id="nex-tit">
                                <div id="nex-tit-l">다음 글</div>
                                <div id="nex-tit-r">${nextTitle}</div>
                            </div>
                        </div>
                        <div id="main-b1-b"><hr></div>
                    </div>
                    <div id="main-b2"></div>
                </div>
            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>
    </section>
</body>
</html>