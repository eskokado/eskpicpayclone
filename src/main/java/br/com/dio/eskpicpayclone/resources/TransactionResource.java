package br.com.dio.eskpicpayclone.resources;

import br.com.dio.eskpicpayclone.dto.TransactionDTO;
import br.com.dio.eskpicpayclone.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase <TransactionDTO>{

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO,
                                               UriComponentsBuilder uriBuilder) {
        TransactionDTO transactionReturnDTO = transactionService.process(transactionDTO);
        return responseItemCreatedWithURI(
                transactionReturnDTO, uriBuilder,
                "/transactions/{code}",
                transactionReturnDTO.getCode());
    }

    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> listPerPage(
            @PageableDefault(page = 0, size = 24) Pageable pagination,
            @RequestParam String login) {
        Page<TransactionDTO> transactionDTOPage = transactionService.listPerPage(pagination, login);
        return responsePagedListOfItems(transactionDTOPage);
    }
}
