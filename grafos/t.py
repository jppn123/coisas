def round_robin(processes, burst_time, quantum):
    n = len(processes)
    waiting_time = [0] * n
    turnaround_time = [0] * n
    total_waiting_time = 0
    total_turnaround_time = 0
    time_elapsed = 0
    queue = []

    while True:
        all_done = True
        for i in range(n):
            if burst_time[i] > 0:
                all_done = False
                if burst_time[i] <= quantum:
                    time_elapsed += burst_time[i]
                    turnaround_time[i] = time_elapsed
                    burst_time[i] = 0
                else:
                    time_elapsed += quantum
                    burst_time[i] -= quantum
                queue.append(processes[i])

        if all_done:
            break

    for i in range(n):
        waiting_time[i] = turnaround_time[i] - burst_time[i]
        total_waiting_time += waiting_time[i]
        total_turnaround_time += turnaround_time[i]

    average_waiting_time = total_waiting_time / n
    average_turnaround_time = total_turnaround_time / n
    throughput = n / time_elapsed

    return average_waiting_time, average_turnaround_time, throughput, queue

# Exemplo de uso
processes = ["P1", "P2", "P3"]
burst_time = [10, 5, 8]
quantum = 6
wat, tat, tp, execution_order = round_robin(processes, burst_time, quantum)

print(f"Tempo médio de espera: {wat:.2f} unidades de tempo")
print(f"Tempo médio de retorno: {tat:.2f} unidades de tempo")
print(f"Vazão: {tp:.2f} processos por unidade de tempo")
print(f"Ordem de execução: {execution_order}")
