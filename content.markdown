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


      <footer class="site-footer">
<span>Voici une liste de sites/blogs que je consulte régulièrement
<table class="styled-table">
  <thead>
    <tr>
      {% for key in site.data.reading_list[0] %}
        <th>{{ key[0] | capitalize }}</th>
      {% endfor %}
    </tr>
  </thead>
  <tbody>
    {% for row in site.data.reading_list %}
      <tr>
        {% for pair in row %}
          <td>{{ pair[1] }}</td>
        {% endfor %}
      </tr>
    {% endfor %}
  </tbody>
</table>
</span>
    <span class="site-footer-credits">Cette page est générée par<a href="https://pages.github.com">GitHub Pages</a>.</span>
    </footer>

</main>
