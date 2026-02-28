### Description du projet

Ce projet consiste à migrer un site existant hébergé sur **Blogger**(https://testavecexcel.blogspot.com)
vers un site statique basé sur **Jekyll**, puis à le déployer automatiquement via **GitHub Pages**.  
L’objectif est de moderniser l’architecture du site, améliorer ses performances, faciliter la maintenance et bénéficier d’un hébergement gratuit et fiable 
 
### Objectifs

- Migrer les articles et pages depuis Blogger (fichiers HTML, XML, CSV)
- Convertir le contenu au format compatible Jekyll (Markdown)
- Installer un thème Jekyll (par exemple : cayman)
- Mettre en place une structure de site statique claire et maintenable
- Déployer le site via GitHub Pages
- Préserver le référencement (URLs, métadonnées, etc.)

### Technologies utilisées

- **Blogger** (site source)
- **Jekyll** (générateur de site statique)
- **Markdown**
- **Liquid**
- **Git & GitHub**
- **GitHub Pages**
- **HTML / CSS / SASS**

## Import

`Prérequis côté Windows`

## Outils nécessaires

Ruby (avec DevKit) → recommandé : Ruby 2.6 ou 2.7
Git Bash (beaucoup plus fiable que CMD)

Si Ruby n’est pas encore installé :
https://rubyinstaller.org
(prendre Ruby+Devkit et cocher “Add Ruby to PATH”)

Vérifie :
ruby -v
gem -v

## Installer jekyll-import

Dans Git Bash ou PowerShell :
gem install jekyll-import
(aucun problème avec Jekyll 3.10.0)

## Préparer l’export Blogger

Blogger → Paramètres
Gérer le blog
Sauvegarder le contenu
Tu obtiens un fichier .xml
Copie ce fichier dans le dossier racine de ton site Jekyll

Exemple :
C:\\sites\\mon-blog-jekyll\\blogger-export.xml

Se placer dans le dossier Jekyll :

cd /c/sites/mon-blog-jekyll

## Commande import Blogger (Windows)

ruby -r rubygems -e "require 'jekyll-import';
JekyllImport::Importers::Blogger.run({
&nbsp; 'source' => 'blogger-export.xml',
&nbsp; 'nojekyll' => false
})"








