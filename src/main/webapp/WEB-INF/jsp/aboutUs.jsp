<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="about">
    <h2 class="about-header u-center-text">Meet the Team</h2>

    <c:url var="jakeImgURL" value="/img/jake_casassa.jpg" />
    <c:url var="archieImgURL" value="/img/archie_cooley.jpg" />
    <c:url var="jeffImgURL" value="/img/jeff_crosley.jpg" />
    <c:url var="kiranImgURL" value="/img/kiran_desimone.jpg" />
    <c:url var="brooksImgURL" value="/img/brooks_gathagan.jpg" />
    <c:url var="alyssaImgURL" value="/img/alyssa_hernandez.jpg" />
    
    <div class="team">
        <div class="team-member u-color1">
            <img src="${ jakeImgURL }" alt="jake casassa headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Jake Casassa</h3>
                <p class="team-member-bio">
                    Lorem ipsum dolor sit amet, qui bonorum consectetuer et.
                </p>
                <div class="team-member__links">
                    <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
        <div class="team-member u-color2">
            <img src="${ archieImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Archie Cooley</h3>
                <p class="team-member-bio">
                    Dolor nominavi praesent ei vim, has viris lobortis et, est.
                </p>
                <div class="team-member__links">
                    <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
        <div class="team-member u-color3">
            <img src="${ jeffImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Jeff Crosley</h3>
                <p class="team-member-bio">
                    Te qui quis adolescens, id eos soleat scripserit, ne his.
                </p>
                <div class="team-member__links">
                                        <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
        <div class="team-member u-color4">
            <img src="${ kiranImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Kiran DeSimone</h3>
                <p class="team-member-bio">
                    Sea duis putant et, sed sint corpora antiopam ut. Nibh.
                </p>
                <div class="team-member__links">
                                        <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
        <div class="team-member u-color5">
            <img src="${ brooksImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Brooks Gathagan</h3>
                <p class="team-member-bio">
                    Eos nullam mollis similique cu, qui ea harum invidunt.
                </p>
                <div class="team-member__links">
                                        <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
        <div class="team-member u-color6">
            <img src="${ alyssaImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Alyssa Hernandez</h3>
                <p class="team-member-bio">
                    Cu clita vituperata eam, ius apeirian intellegat an, ex.
                </p>
                <div class="team-member__links">
                    <a href="#" class="team-member-link"><ion-icon name="logo-linkedin"></ion-icon></a>
                    <a href="#" class="team-member-link"><ion-icon name="logo-github"></ion-icon></a>
                </div>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />