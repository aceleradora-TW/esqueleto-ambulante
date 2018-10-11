const moment = require('moment');

const Pikaday = require('pikaday');
const pikadayCss = require('pikaday/css/pikaday.css');

const CaixaDeBusca = require('./caixa-de-busca');

window.CaixaDeBusca = CaixaDeBusca(moment, Pikaday);