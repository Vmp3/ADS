# Usar a imagem oficial do Node.js como base
FROM node:latest

# Definir o diretório de trabalho no container
WORKDIR /usr/src/app

# Copiar o arquivo package.json e package-lock.json (se existir)
COPY app/package*.json ./

# Instalar dependências do projeto
RUN npm install

# Copiar os outros arquivos do projeto para o diretório de trabalho
COPY app/ .

# O comando que será executado quando o container iniciar
CMD ["node", "server.js"]

