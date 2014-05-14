<%-- 
    Document   : tracks
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page import="Model.Album"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Track"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control","no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Tracks</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <link href="listenercss/listenercss.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container" >
            <jsp:include page="header.jsp"/>
            <p>Credits in portefeuille: ${requestScope.credits}</p>
            <div class="BuyCredits">
                <form action="CreditServlet" method="post" name="BuyCredits">
                    <h2>Selecteer een prijsplan</h2>
                    <div class="inputform">
                        <div class="left">
                            <input type="radio" value="plan_10" name="plan" check="checked" />
                            <label for="plan_10">€10</label><br />
                            <span class="description">100 MyVibe-credits</span><br />
                            <input type="radio" value="plan_15" name="plan" />
                            <label for="plan_15">€15</label><br />
                            <span class="description">150 MyVibe-credits</span><br />
                        </div>
                        <div class="right">
                            <input type="radio" value="plan_25" name="plan" />
                            <label for="plan_15">€25</label><br />
                            <span class="description">250 MyVibe-credits</span><br />
                            <input type="radio" value="plan_50" name="plan" />
                            <label for="plan_50">€50</label><br />
                            <span class="description">500 MyVibe-credits</span><br />
                        </div>
                    </div>
                    <h2>Selecteer een betaalmethode</h2>
                    <div class="inputform">
                        <div class="left">
                            <input type="radio" value="pay_visa" name="pay_method" check="checked" />
                            <label for="VISA"><img src="images/pay_methods/visa_small.png" alt="VISA" />VISA</label><br />
                            <input type="radio" value="pay_paypal" name="pay_method" />
                            <label for="Paypal"><img src="images/pay_methods/paypal_small.png" alt="Paypal" />Paypal</label><br />
                            <input type="radio" value="pay_sms" name="pay_method" />
                            <label for="SMS"><img src="images/pay_methods/sms_small.png" alt="SMS" />SMS</label><br />
                            <input type="radio" value="pay_bitcoin" name="pay_method" />
                            <label for="SMS"><img src="images/pay_methods/bitpay_small.png" alt="Bitcoin" />Bitcoin</label>
                        </div>
                        <div class="right">
                            <input type="radio" value="pay_bancontact" name="pay_method" />
                            <label for="SMS"><img src="images/pay_methods/bancontact_small.png" alt="Bancontact" />Bancontact</label><br />
                            <input type="radio" value="pay_mastercard" name="pay_method" />
                            <label for="SMS"><img src="images/pay_methods/mastercard_small.png" alt="MasterCard" />MasterCard</label><br />
                            <input type="radio" value="pay_overschrijving" name="pay_method" />
                            <label for="SMS"><img src="images/pay_methods/overschrijving_small.png" alt="Overschrijving" />Overschrijving</label><br />
                        </div>
                    </div>
                        <input type="submit" value="Naar betaalpagina"></input>
                </form>
            </div>
        </div>
    </body>
</html>
