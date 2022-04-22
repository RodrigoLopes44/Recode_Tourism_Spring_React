import './contato.css';
import img from '../../Assets/Logos/mail_ready.png'

export default function Contato() {
    return(
      <>
        <div class="jumbotron text-center">
                <h2 class="display-4">
                    Olá, viajante! Tem alguma dúvida, sugestão ou crítica? <br />
                    Preencha os campos abaixo e em breve retornaremos!
                </h2>
                <br />
                <hr />
        </div>

        <div className="row p-0 m-0 justify-content-around">
          <form>
            <div class="form-group">
              <label for="nome">Nome:</label>
              <input type="text" class="form-control" id="nome" />
            </div>

            <div class="form-group">
              <label for="email">Email:</label>
              <input type="email" class="form-control" id="email" placeholder="nome@gmail.com" />
            </div>

            <div class="form-group">
              <label for="telefone">Telefone:</label>
              <input type="text" class="form-control" id="telefone" />
            </div>

            <div class="form-group">
              <label for="choices">Melhor forma para contato:</label>
              <select class="form-control" id="choices">
                <option>WhatsApp</option>
                <option>E-mail</option>                
              </select>
            </div>

            <div class="form-group">
              <label for="msg">Escreva sua mensagem:</label>
              <textarea class="form-control" id="msg" rows="3"></textarea>
            </div>

            <button type="button" class="btn btn-outline-info">Enviar</button>          
          </form>

          <img className='img-fluid' src={img} alt="Imagem de Contato" />
        </div>
      </>
    )
}
