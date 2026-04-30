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

<main>
 <div><p>
        <!-- not sure about the reverse, the plugin offers this option, too! --> 
            {% assign sites = paginator.posts | reverse %}
            {% for file in sites %}
            {{ file }}
            {% endfor %}
            <a href="{{ paginator.previous_page_path }}">Précédent</a> | <a
                href="{{ paginator.next_page_path }}">Suivant</a>
            {{ paginator.page }}
            {{ paginator.total_pages | inspect }}
            {% for page in paginator.total_pages %}
            {{ page }}
            {% endfor %}
          </p></div>
<hr>
</main>





