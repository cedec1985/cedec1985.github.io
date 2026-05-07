---
layout: default
pagination:
    enabled: true
---
<div>
{% for post in site.posts %}
  <h2><a href="{{ post.url }}">{{ post.title }}</a>
  <span class="date">{{ post.date | date_to_string }}</span>
  </h2>
{% endfor %}
</div>