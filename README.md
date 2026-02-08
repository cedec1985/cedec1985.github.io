## Description du projet

Ce projet consiste à migrer un site existant hébergé sur **Blogger** vers un site statique basé sur **Jekyll**, puis à le déployer automatiquement via **GitHub Pages**.  
L’objectif est de moderniser l’architecture du site, améliorer ses performances, faciliter la maintenance et bénéficier d’un hébergement gratuit et fiable.

## Objectifs

- Migrer les articles et pages depuis Blogger
- Convertir le contenu au format compatible Jekyll (Markdown)
- Mettre en place une structure de site statique claire et maintenable
- Déployer le site via GitHub Pages
- Préserver le référencement (URLs, métadonnées, etc.)

## Technologies utilisées

- **Blogger** (site source)
- **Jekyll** (générateur de site statique)
- **Markdown**
- **Liquid**
- **Git & GitHub**
- **GitHub Pages**
- **HTML / CSS**

## Prérequis

Avant de commencer, assure-toi d’avoir installé :

Ruby version 2.7.0 ou plus
RubyGems
GCC and Make

```bash
gem install bundler jekyll
jekyll new myblog
cd myblog
bundle exec jekyll serve

## Instructions 

Installer les prérequis (voir sites d'installations respectifs)
Installer les gems Jekyll and Bundler