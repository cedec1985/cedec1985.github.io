require 'csv'
require 'fileutils'

csv = CSV.read('_data/reading_list.csv', headers: true)
csv.each do |row|
  title = row['title']
  homepage_url = row['homepage_url']
  feed_url = row['feed_url']

  # Create a filename based on the title
  filename = "_posts_imported/#{title.downcase.gsub(' ', '-')}.md"

  # Create the content of the markdown file
  content = <<~MARKDOWN
    ---
    title: "#{title}"
    homepage_url: "#{homepage_url}"
    feed_url: "#{feed_url}"
    ---

    # #{title}

    Homepage: [#{homepage_url}](#{homepage_url})
    
    Feed: [#{feed_url}](#{feed_url})
  MARKDOWN

  # Write the content to the markdown file
  File.write(filename, content)
end