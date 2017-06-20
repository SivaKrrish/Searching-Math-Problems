<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>

    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <title>Search me : Search Question in the BANK</title>
    <meta name="description" content="Ask me Responsive Questions and Answers Template">
    <meta name="author" content="2code.info">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Main Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    <!-- Skins -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/skins/skins.css">

    <!-- Responsive Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">

    <!-- Favicons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png">

</head>
<body>

<div id="accordions" class="row">
    <div class="col-md-6">
        <div class="page-content page-shortcode" style="margin-left: 40% ; margin-top: 6%; height:100%; width: 123%;">
            <div class="boxedtitle page-title"><h2 style="margin-left: 40% ; padding-top: 10px">Search Results</h2>
            </div>

            <div class="accordion toggle-accordion">

                <c:if test="${fn:length(dataMap) gt 0}">

                    <c:forEach items="${dataMap}" var="entry">

                        <h4 class="accordion-title"><a href="#">${fn:length(entry.value)} Records found for keyword : ${entry.key}</a></h4>

                        <div class="accordion-inner">

                            <c:choose>

                                <c:when test="${fn:length(entry.value) gt 0 }">

                                    <c:forEach items="${entry.value}" var="item" varStatus="loop">

                                        <div class="accordion-inner-div">
                                                ${item}
                                        </div>

                                    </c:forEach>

                                </c:when>
                                <c:otherwise>

                                    <div class="accordion-inner-div">
                                        No data found for ${entry.key}
                                    </div>

                                </c:otherwise>

                            </c:choose>

                        </div>


                    </c:forEach>

                </c:if>

            </div>

        </div>
        <!-- End page-content -->
    </div>
    <!-- End Toggle -->
</div>

<!-- js -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/html5.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/twitter/jquery.tweet.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jflickrfeed.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.inview.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.tipsy.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tabs.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.flexslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.nav.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tags.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.bxslider.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
<!-- End js -->
<br/>
        
            <div style="background-color: burlywood;height: 30px;width:100%;text-align: center">
                <i > Copyright  2015 </i>
            </div>
</body>

</html>