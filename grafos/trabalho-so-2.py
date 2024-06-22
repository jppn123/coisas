class Process:
    def __init__(self, burst_time):
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.waiting_time = 0
        self.turnaround_time = 0


def roundRobin(processes, quantum):
    tamPr = len(processes)
    total_waiting_time = 0
    total_turnaround_time = 0
    completed_processes = 0
    time = 0
    queue = []
    exec = ""

    while True:
        for p in processes:
            if p.remaining_time > 0 and p.burst_time > 0:
                if p.remaining_time <= quantum:
                    time += p.remaining_time + 1
                    p.burst_time -= p.remaining_time
                    p.remaining_time = 0
                else:
                    time += quantum + 1
                    p.burst_time -= quantum
                    p.remaining_time -= quantum

                exec += str(processes.index(p) + 1) + " "
                if p.burst_time == 0:
                    completed_processes += 1
                    p.turnaround_time = time
                    total_turnaround_time += p.turnaround_time
                    total_waiting_time += p.waiting_time
                else:
                    queue.append(p)

        if completed_processes == tamPr:
            break
        
        if queue:
            next_process = queue.pop(0)
            next_process.waiting_time = time - next_process.turnaround_time
            queue.append(next_process)

    average_waiting_time = total_waiting_time / tamPr
    average_turnaround_time = total_turnaround_time / tamPr
    throughput = tamPr / time

    return average_waiting_time, average_turnaround_time, throughput, exec



# Define processos com burst time diferentes
processes = [Process(10), Process(5), Process(8)]
quantum = 6


print(f"Quantum = {quantum}")
avg_waiting_time, avg_turnaround_time, throughput, sequence_of_execution = roundRobin(processes, quantum)
print(f"Tempo médio de espera: {avg_waiting_time}")
print(f"Tempo médio de retorno: {avg_turnaround_time}")
print(f"Vazão: {throughput}")
print(f"Sequência de execução: {sequence_of_execution}")
print()
