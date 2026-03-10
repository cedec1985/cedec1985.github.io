---
title : import du feed RSS
homepage_url : https://yesweblog.fr/
feed_url : https://yesweblog.fr/feed/
---
<main class="container">
{% for feed in site.data.reading_list %}

## les blogs que je consulte régulièrement

<div class="container">
<span class="site-footer">
|{{ feed.title }}|<em>{{ feed.homepage_url }}</em>
</span>
</div>
{% endfor %}
</main>