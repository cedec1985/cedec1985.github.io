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
            {% assign sites = paginator.posts | reverse %}
            {% for file in sites %}
            {{ file }}
            {% endfor %}
            <a href="{{ paginator.previous_page_path }}">Previous page</a> | <a
                href="{{ paginator.next_page_path }}">Next page</a>
            {{ paginator.page }}
            {{ paginator.total_pages | inspect }}
            {% for page in paginator.total_pages %}
            {{ page }}
            {% endfor %}
          </p></div>
<hr>
<main>