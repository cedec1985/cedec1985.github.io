---
title: contenu du blog
permalink : /content.html
logo: assets/logo.jpeg
pagination :
  enabled: true
---

<style>
/* Reset léger */
* {
  box-sizing: border-box;
}

/* Fond général avec dégradé moderne */
body {
  font-family: 'Segoe UI', Roboto, sans-serif;
  background: linear-gradient(135deg, #1e3c72, #2a5298);
  color: #ffffff;
  line-height: 1.6;
}

/* Conteneur principal */
.wrapper {
  max-width: 1100px;
  margin: auto;
  padding: 40px;
}

/* Barre du haut */
.site-title {
  font-size: 1.4rem;
  font-weight: 600;
  text-decoration: none;
  color: white;
  transition: 0.3s ease;
}

.site-title:hover {
  color: #00f2fe;
}

/* Navigation */
.site-nav {
  float: right;
}

.page-link {
  margin-left: 20px;
  text-decoration: none;
  color: #ffffff;
  font-weight: 500;
  transition: 0.3s;
}

.page-link:hover {
  color: #00f2fe;
}

/* Header principal avec effet glassmorphism */
.page-header {
  text-align: center;
  padding: 40px 40px 40px 40px;
  background: rgba(255, 255, 255, 0.08);
  backdrop-filter: blur(10px);
  border-radius: 15px;
  margin: 30px auto;
  width: 80%;
  box-shadow: 0 8px 30px rgba(0,0,0,0.3);
}

.project-name {
  font-size: 1.5rem;
  margin-bottom: 10px;
}

.project-tagline {
  font-weight: 300;
}

/* Section contenu */
.main-content {
  background: #ffffff;
  color: #333;
  border-radius: 15px;
  padding: 40px;
  margin-top: 40px;
  box-shadow: 0 8px 30px rgba(0,0,0,0.15);
}

/* Titres */
h2 {
  margin-top: 40px;
  margin-bottom: 40px;
  color: #ffffff;
}

/* Articles récents */
.post-list li {
  list-style: none;
  margin-bottom: 30px;
  padding: 25px;
  border-radius: 10px;
  transition: 0.3s ease;
  background: linear-gradient(135deg, #f5f7fa, #e4ecf7);
}

.post-list li:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 30px rgba(0,0,0,0.15);
}

/* Bouton recherche */
#searchButton {
  background: linear-gradient(135deg, #00f2fe, #4facfe);
  border: none;
  padding: 8px 16px;
  color: white;
  border-radius: 20px;
  cursor: pointer;
  transition: 0.3s;
}

#searchButton:hover {
  opacity: 0.8;
}

/* Footer */
.site-footer {
  margin-top: 30px;
  padding: 30px;
  text-align: center;
  background: linear-gradient(135deg, #141e30, #243b55);
  color: white;
}

.site-footer a {
  color: #00f2fe;
  text-decoration: none;
}

.site-footer a:hover {
  text-decoration: underline;
}

/* Responsive */
@media (max-width: 768px) {
  .site-nav {
    float: none;
    text-align: center;
    margin-top: 30px;
  }

  .page-header {
    padding: 30px 15px;
  }

  .project-name {
    font-size: 2rem;
  }
}
</style>
![Logo Excel](https://static0.makeuseofimages.com/wordpress/wp-content/uploads/2022/03/excel-logo-blue.jpg?q=50&fit=crop&w=1488&h=837&dpr=1.5)
<main class="container">
{% for item in site.data.settings %}
    <em>{{ item.blog_description }}</em>
    <p><span> 
      <form action="/search" id="searchThis" method="get" style="display: inline; margin: 10px auto;"><input id="searchBox" name="q" onblur="if(this.value=='')this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value='';" type="text" value="Rechercher sur ce blog" vinput="" /> <input id="searchButton" type="submit" value="Chercher" /></form>
    </span></p>
{% endfor %}
<div class="footer-col footer-col-1">
  <a data-flip-widget="ico"
          href="https://flipboard.com/@CedricDeC?utm_campaign=tools&utm_medium=follow&action=follow">
          <img src="https://cdn.flipboard.com/badges/flipboard_mrsw.png" alt="Flipboard" />
          </a><script src="https://cdn.flipboard.com/web/buttons/js/flbuttons.min.js"
          type="text/javascript"></script>
</div>
  {% include logo.html url="http://yesweblog.fr/" file="../assets/logo.jpeg" alt="logo yesweblog" width="40" %}
<hr>
</main>


