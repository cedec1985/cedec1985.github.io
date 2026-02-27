---
layout: home
title: contenu du blog
permalink : /content.html/
---

![Logo](http://www.assistantepro.com/images/p/excel-2-1590246387.jpg)

  <main class="container">
   
{% for item in site.data.settings %}
    {{content}}
    <strong>{{ item.blog_name }}</strong>
    <em>{{ item.blog_description }}</em>
    <p><span> 
      <form action="/search" id="searchThis" method="get" style="display: inline; margin: 10px auto;"><input id="searchBox" name="q" onblur="if(this.value=='')this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value='';" type="text" value="Rechercher sur ce blog" vinput="" /> <input id="searchButton" type="submit" value="Chercher" /></form>
    </span></p>
    <div>
      <p>
        {{ item.max_num }}
        {{ item.max_unit }}
      </p>
    </div>
{% endfor %}
  </main>
