---
layout: default
title: contenu du blog
permalink : /content.html/
---

![Logo Excel](https://static0.makeuseofimages.com/wordpress/wp-content/uploads/2022/03/excel-logo-blue.jpg?q=50&fit=crop&w=1488&h=837&dpr=1.5)

<main class="container">
{% for item in site.data.settings %}
    <em>{{ item.blog_description }}</em>
    <p><span> 
      <form action="/search" id="searchThis" method="get" style="display: inline; margin: 10px auto;"><input id="searchBox" name="q" onblur="if(this.value=='')this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value='';" type="text" value="Rechercher sur ce blog" vinput="" /> <input id="searchButton" type="submit" value="Chercher" /></form>
    </span></p>
{% endfor %}
    
  <a data-flip-widget="ico"
          href="https://flipboard.com/@CedricDeC?utm_campaign=tools&utm_medium=follow&action=follow">
          <img src="https://cdn.flipboard.com/badges/flipboard_mrsw.png" alt="Flipboard" />
          </a><script src="https://cdn.flipboard.com/web/buttons/js/flbuttons.min.js"
          type="text/javascript"></script>
</main>
