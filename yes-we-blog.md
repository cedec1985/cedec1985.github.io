---
title: "Yes We Blog !"
homepage_url: "https://yesweblog.fr/"
feed_url: "https://yesweblog.fr/feed/"
permalink : /yesweblog.html/
---

<footer>
<span class="site-footer-credits">Cette page est générée par<a href="https://pages.github.com">GitHub Pages</a>.</span>
<p>
{% for blog in site.posts.yesweblog %}
 <p>Voici une liste de sites/blogs que je consulte régulièrement :</p>
  <a href="{{ blog.homepage_url }}">{{ blog.title }}</a><br>
{% endfor %}
</p>
</footer>
