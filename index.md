---
layout: default
pagination:
    enabled: true
---

<p class="pagination">
{% for post in paginator.posts %}
  <h2><a href="{{ post.url }}">{{ post.title }}</a></h2>
  <p>{{ post.excerpt }}</p>
 {% endfor %}
<p>
{% if paginator.next_page %}
  <a href="{{ paginator.next_page_path }}">Suivant</a>
{% endif %}
{% if paginator.previous_page %}
  <a href="{{ paginator.previous_page_path }}">Précédent</a>
{% endif %}
</p>
<p>
{% if paginator.total_pages > 1 %}
  <p>Page {{ paginator.page }} sur {{ paginator.total_pages }}</p>
{% endif %}
</p>
</p>


