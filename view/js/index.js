const fontAwesome = require('@fortawesome/fontawesome-free/js/all');
const moment = require('moment');
const Pikaday = require('pikaday');

const CaixaDeBusca = require('./caixa-de-busca');

window.CaixaDeBusca = CaixaDeBusca(moment, Pikaday);