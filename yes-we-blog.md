---
title: "Yes We Blog !"
homepage_url: "https://yesweblog.fr/"
feed_url: "https://yesweblog.fr/feed/"
permalink : /yesweblog.html/
---

<footer>
 <span class="site-footer-credits">Cette page est générée par<a href="https://pages.github.com">GitHub Pages</a>.</span>
<p>
 <p>Voici une liste de sites/blogs que je consulte régulièrement :</p>
 {% for post in site.posts where post.title == 'Yes We Blog !' %}
  <h2><a href="{{ post.url }}">{{ post.title }}</a></h2>
  <p>{{ post.excerpt }}</p>
{% endfor %}
</p>
</footer>
