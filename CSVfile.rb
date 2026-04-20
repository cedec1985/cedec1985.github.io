require 'csv'
require 'fileutils'

csv = CSV.read('_data/reading_list.csv', headers: true)
csv.each do |row|
  title = row['title']
  url = row['url']
  feed_url = row['feed_url']

  # Créer les fichiers markdown dans le dossier _posts_imported
  filename = "_posts_imported/#{title.downcase.gsub(' ', '-')}.md"

  # Créer le contenu du fichier markdown
  content = <<~MARKDOWN
    ---
    title: "#{title}"
    url: "#{url}"
    feed_url: "#{feed_url}"
    ---

    # #{title}

    Homepage: [#{url}](#{url})
    
    Feed: [#{feed_url}](#{feed_url})
  MARKDOWN

  # Écrire le contenu dans le fichier markdown
  File.write(filename, content)
end
