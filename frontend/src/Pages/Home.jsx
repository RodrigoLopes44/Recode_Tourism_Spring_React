import { Link } from "react-router-dom";

import rj from '../Assets/Catalogo/RJ/ilha-grande-pousada.svg';
import sp from '../Assets/Catalogo/SP/pousada-vila-olimpia-SP.svg';
import mg from '../Assets/Catalogo/MG/pousada-pocos-de-caldas-MG.svg';
import ba from '../Assets/Catalogo/BA/pousada-ilheus-BA.svg'

export default function Home() {
    return (
        <>
            <div className="container-fluid mt-3">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src={rj} alt="First slide" />
                        </div>
                        
                        <div class="carousel-item">
                            <img class="d-block w-100" src={sp} alt="Second slide" />
                        </div>
                        
                        <div class="carousel-item">
                            <img class="d-block w-100" src={mg} alt="Third slide" />
                        </div>
                    </div>
                    
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

                <hr />
                

                <div className="content m-4">
                    <h1 className="head-center">Você conhece a <u>Ponte da Saudade?</u></h1>
                    <br />
                
                    <p className="info-center">
                    Situada em Paquetá, a Ponte da Saudade tem esse nome porque, segundo a
                    lenda, era o porto onde os escravos eram desembarcados do navio
                    negreiro. <br />
                    Um desses escravos não suportou a perda da amada, que morreu durante a
                    viagem, e todo dia retornava à ponte para esperar que Iemanjá a
                    trouxesse de volta
                    </p>
                    <br /><br />
                
                    <h4 className="mid-center">
                        Não perca mais tempo e conheça agora nossos pacotes, clicando<Link to='/Viagens'> aqui!</Link>
                    
                    </h4>
                </div>
                
            </div>            
        </>
    );
}