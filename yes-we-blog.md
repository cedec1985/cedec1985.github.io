---
title: "Yes We Blog !"
url: "https://yesweblog.fr/"
feed_url: "https://yesweblog.fr/feed/"
permalink : /yesweblog.html/
pagination :
    enabled: true
---
<main>
 <div><p>
        <!-- not sure about the reverse, the plugin offers this option, too! --> 
            <a href="{{ paginator.previous_page_path }}">Précédent</a> | <a
                href="{{ paginator.next_page_path }}">Suivant</a>
            {{ paginator.page }}
            {{ paginator.total_pages | inspect }}
            {% for page in paginator.total_pages %}
            {{ page }}
            {% endfor %}
          </p></div>
<hr>
<main>