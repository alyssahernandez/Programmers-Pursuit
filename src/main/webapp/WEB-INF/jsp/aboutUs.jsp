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
                <p class="team-member__bio">
                    Lorem ipsum dolor sit amet, qui bonorum consectetuer et. Id equidem percipit vel. Ea idque dictas quo, sea ancillae constituam ad, ei eam homero inimicus. Nam eu unum mollis blandit. Ad has veritus philosophia. No tale convenire vix, at eius necessitatibus mea.
                </p>
                <div class="team-member__links">
                    <div class="team-member__links--link">
                        L1
                    </div>
                    <div class="team-member__links--link">
                        L2
                    </div>
                </div>
            </div>
        </div>
        <div class="team-member u-color2">
            <img src="${ archieImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Archie Cooley</h3>
                <p class="team-member__bio">
                    Dolor nominavi praesent ei vim, has viris lobortis et, est erat causae fabellas cu. Mollis ponderum vulputate ex pro, in regione accumsan eos. Ad sea debitis inimicus, vim eu eros elit, ex oporteat platonem pri. Ex qui quis consul abhorreant.
                </p>
                <div class="team-member__links">links</div>
            </div>
        </div>
        <div class="team-member u-color3">
            <img src="${ jeffImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Jeff Crosley</h3>
                <p class="team-member__bio">
                    Te qui quis adolescens, id eos soleat scripserit, ne his saepe scaevola consequat. Ex has eros erant. His ut ridens efficiendi, equidem mediocritatem quo ex. Semper audiam voluptatum an eum, invidunt verterem euripidis cu pro, aeque vidisse dolorem nam at. Semper signiferumque ius in, has diam timeam te. Pro error primis possit te, te stet ferri duo, autem perfecto deserunt id pri.
                </p>
                <div class="team-member__links">links</div>
            </div>
        </div>
        <div class="team-member u-color4">
            <img src="${ kiranImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Kiran DeSimone</h3>
                <p class="team-member__bio">
                    Sea duis putant et, sed sint corpora antiopam ut. Nibh intellegat eum id. Justo tacimates sententiae ut nam, te eos summo graeco saperet, vel mentitum forensibus ut. Feugiat hendrerit dissentiet mei ea, ad has soleat luptatum. In maiorum vivendo praesent quo, in vero repudiandae pro, in vix accumsan laboramus. Vel mediocrem splendide cu, ad mel primis elaboraret, quidam labores et usu.
                </p>
                <div class="team-member__links">links</div>
            </div>
        </div>
        <div class="team-member u-color5">
            <img src="${ brooksImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Brooks Gathagan</h3>
                <p class="team-member__bio">
                    Eos nullam mollis similique cu, qui ea harum invidunt. An quo saepe volutpat. Id his dico rebum, eam eu delectus patrioque laboramus, iriure salutatus eos ea. Facer primis neglegentur usu ea, at pro oblique sadipscing.
                </p>
                <div class="team-member__links">links</div>
            </div>
        </div>
        <div class="team-member u-color6">
            <img src="${ alyssaImgURL }" alt="headshot" class="team-member__headshot">
            <div class="team-member__details">
                <h3 class="team-member-name">Alyssa Hernandez</h3>
                <p class="team-member__bio">
                    Cu clita vituperata eam, ius apeirian intellegat an, ex possit dolores his. Dolores fastidii sea ut, deseruisse interesset vis in. Saepe causae diceret an per, oratio utroque cum ne. Mel eu justo legere definitionem. Est reque impetus omnesque ei, ad eos minim ullamcorper, odio vidit tincidunt te vel. Summo causae at vis, nihil antiopam est cu, porro mentitum voluptatum te has.
                </p>
                <div class="team-member__links">links</div>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />