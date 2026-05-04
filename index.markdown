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

<div class="pagination"><p>
            <a href="{{ paginator.previous_page_path }}">Précédent
</a>| <a
                href="{{ paginator.next_page_path }}">Suivant
            </a>
</p></div> 

<p class="rss-subscribe" style="color: blue; font-size: 11px; font-weight: bold;">
{% if paginator.total_pages > 1 %}
Page  {{ paginator.page }} sur {{ paginator.total_pages }}
{% endif %}
</p>
<hr>




