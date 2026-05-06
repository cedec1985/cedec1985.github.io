---
layout: default
pagination:
    enabled: true
---

<p class="pagination">
{% for post in paginator.posts %}
  <h2><a href="{{ post.url }}">{{ post.title }}</a> - <span class="date">{{ post.date | date_to_string }}</span>
  </h2>
{% endfor %}
<p>
{% if paginator.total_pages > 1 %}
Page {{ paginator.page }} sur {{ paginator.total_pages }}
{% endif %}
</p>
  <p>
    {% if paginator.previous_page %}
      <a href="{{ paginator.previous_page_path | prepend: site.baseurl }}">Articles précédents</a>
    {% endif %}
    {% if paginator.next_page %}
      <a href="{{ paginator.next_page_path | prepend: site.baseurl }}">Articles plus récents</a>
    {% endif %}
</p>
</p>