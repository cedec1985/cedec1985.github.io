---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
pagination: 
    enabled: true
---

{% include logo.html 
url="http://yesweblog.fr/"
file="../assets/logo.jpeg"
alt="logo yesweblog"
width="40"
%}

{% for post in paginator.posts %}
       <span class="post-meta">
              {{ post.date | date: "%b %-d, %Y" }}</span>
            <h3>
              <a class="post-link" href="{{ post.url | relative_url }}">
                {{ post.title }}
              </a>
            </h3>
{% endfor %}

{% if paginator.previous_page %}
        <a class="pagination-link pagination-previous" href="{{ paginator.previous_page_path | prepend: site.baseurl}}">&laquo; Previous</a>
{% endif %}

<span class="pagination-page-number">Page {{ paginator.page }} of {{ paginator.total_pages }}
</span>

{% if paginator.next_page %}
        <a class="pagination-link pagination-next" href="{{ paginator.next_page_path | prepend: site.baseurl}}">Next &raquo;</a>
{% endif %}




